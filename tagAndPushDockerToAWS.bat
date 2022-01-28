@echo off

aws ecr get-login-password --region ap-east-1 | docker login --username AWS --password-stdin 658836551508.dkr.ecr.ap-east-1.amazonaws.com

for %%i in (config-service discovery-service employee-service organization-service department-service gateway-service) do (
     docker tag spring17/%%i:latest 658836551508.dkr.ecr.ap-east-1.amazonaws.com/spring17/%%i:latest
     docker push 658836551508.dkr.ecr.ap-east-1.amazonaws.com/spring17/%%i:latest
)