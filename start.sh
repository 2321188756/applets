cd `dirname $0`                 #进入根目录

proj_home=$PWD                  #工程根目录
img_output=dev          #生成镜像标签
appname=applets                   #容器名称
port=8080                         #docker暴露端口

#  mvn打包镜像
docker run --rm --name springboot-test -v /root/.m2:/root/.m2 -v "$PWD":/usr/src/maven -w /usr/src/maven maven mvn clean install
echo "镜像打包完成"
# 获得docker容器 id和镜像 id
r_c=`docker ps -a | grep "$appname" | awk '{print $1 }'`
c=`docker ps -a | grep "$appname" | awk '{print $1 }'`
r_img=`docker images | grep "$appname" | awk '{print $3 }'`
# 如果容器正在运行，停止它
if [ "$r_c"x != ""x ]; then
    docker stop "$r_c"
    echo "容器已停止"
fi
# 删除容器
if [ "$c"x != ""x ]; then
    docker rm "$c"
    echo "容器已删除"
fi
# 删除镜像
if [ "$r_img"x != ""x ]; then
    docker rmi "$r_img"
    echo "镜像已删除"
fi

# 生成镜像
docker build -t $img_output .
# 日志目录
mkdir -p $PWD/logs
chmod 777 $PWD/logs

# 启动镜像  8080为工程的端口
docker run -dit --name $appname -p $port:8080 $img_output