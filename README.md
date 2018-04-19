# BocBusServer
the server of the application bus

01、BC0001-应用模式选择
http://111.230.148.118:8080/BocbusServer/Mode.do?param={'head':{'TRACDE':'BC00001','TRADAT':'11111','TRATIM':'11111','USRNAM':'ling123'},'body':{'line':'2','mode':'P'}}

02、BC0002-获取位置
http://111.230.148.118:8080/BocbusServer/QueryLocation.do?param={'head':{'TRACDE':'BC00001','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'1'}}

03、BC0003-选择路线 --感觉没必要

04、BC0004-查看路线
http://111.230.148.118:8080/BocbusServer/BusLine.do?param={'head':{'TRACDE':'BC00004','TRADAT':'11111','TRATIM':'11111','USRNAM':'ling123'},'body':{'line':'2'}}

05、BC0005-上传位置
http://111.230.148.118:8080/BocbusServer/UploadLocation.do?param={'head':{'TRACDE':'BC00002','TRADAT':'11111','TRATIM':'11111','USRNAM':'1'},'body':{'line':'1','longitude':'44444.1111','latitude':'44444.2222'}}

![女神](https://github.com/lyk2655/BocBusServer/raw/master/img/001.png)