# SalaryViewer

Download SQL Server on-premieses https://www.microsoft.com/en-us/sql-server/sql-server-downloads 
Download SQL Managment Studio

   url: jdbc:sqlserver://localhost;databaseName=SalaryViewer;integratedSecurity=true;encrypt=false

   encrypt=false; - connection does not use SSL/TLS encryption.
   integratedSecurity=true; - indicates that Windows authentication

SQL Server version 11 so install sqljdbc-11.2.3.0 
https://learn.microsoft.com/en-us/sql/connect/jdbc/release-notes-for-the-jdbc-driver?view=sql-server-ver16#112

Copy mssql-jdbc_auth-11.2.3.x64.dll from C:\Users\...\Downloads\sqljdbc_11.2.3.0_enu.zip\sqljdbc_11.2\enu\auth\x64
to C:\Program Files\Java\jdk-17\bin 
Source : https://stackoverflow.com/questions/6087819/jdbc-sqlserverexception-this-driver-is-not-configured-for-integrated-authentic