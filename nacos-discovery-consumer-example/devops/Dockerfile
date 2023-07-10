FROM xuxiaoweicomcn/dragonwell17:17-standard-ga-centos

# 从 jar_file.txt 文件中读取 JAR 文件名，并将其赋给 wtx_jar_name 环境变量
ENV wtx_jar_name app.jar
ENV wtx_jvm_settings=" -Djava.security.egd=file:/dev/./urandom -Dprogram.name=$projectName  -Dfile.encoding=UTF-8 -Dlog4j2.formatMsgNoLookups=true "
ENV xms="512m"
ENV xmx="768m"

# 设置时区
ENV TIME_ZONE Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime

WORKDIR /apps

# 复制当前文件夹的所有文件进入容器 /apps
#COPY ./*.yaml ./
# 复制当前文件夹的所有文件进入容器 /apps
COPY ./*.jar  ./$wtx_jar_name


CMD java $wtx_jvm_settings -Xms$xms -Xmx$xmx -XX:MaxMetaspaceSize=256m -jar $wtx_jar_name
