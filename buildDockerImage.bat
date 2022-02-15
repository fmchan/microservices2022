@echo off

for %%i in (config-service discovery-service employee-service organization-service department-service gateway-service reactive-service) do (
     docker build -t "spring17/%%i:latest" %%i --no-cache --pull
)