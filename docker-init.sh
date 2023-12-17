# database init

docker run --publish 3306:3306 \
       -d -v ./data/:/var/lib/mysql \
       -v ./sql_script/:/sql_script \
       -e MYSQL_ROOT_PASSWORD=rootpass \
       --name mariadb mariadb:lts
docker exec mariadb mariadb -u root -prootpass -e "CREATE DATABASE luggage_tracker;"
docker exec -i mariadb sh -c 'mysql -uroot -prootpass luggage_tracker < /sql_script/luggage_table_making.sql'



# tomcat init => using eclipse ver before project finished

#docker run --publish 8080:8080 -d \
#-v /home/han/eclipse-workspace/Luggage_Tracker_demo/:/usr/local/tomcat/wabapps/Luggage_Tracker_demo/ \
#-v /home/han/eclipse-workspace/conf/web.xml:/usr/local/tomcat/wabapps/conf/web.xml \
#-v /home/han/eclipse-workspace/conf/tomcat-users.xml:/usr/local/tomcat/wabapps/conf/tomcat-users.xml \
#--name tomcat tomcat:9
