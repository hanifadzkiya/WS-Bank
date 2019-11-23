# Delete and re-clone
sudo su
cd /home/ubuntu
rm -rf ws-bank
git clone git@gitlab.informatika.org:if3110-2019-02-k03-18/ws-bank.git

# Create WAR file from Java Web App
cd ws-bank

mkdir -p web/WEB-INF/classes
cp -r src/* web/WEB-INF/classes

cp -r lib web/WEB-INF
cp -r META-INF web/WEB-INF/classes

cp -r ../example web/WEB-INF/classes
cp -r ../META-INF web/WEB-INF/classes

cd web
javac $(find ./* | grep .java)
jar -cvf ws-bank_war.war *

# Deploy war to glassfish
rm /opt/glassfish5/glassfish/domains/domain1/autodeploy/ws-bank_war.war
cp ws-bank_war.war /opt/glassfish5/glassfish/domains/domain1/autodeploy
