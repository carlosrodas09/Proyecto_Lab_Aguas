package com.mycompany.config;

public class SecurityConstants {
    public static final String DATASOURCE_LOOKUP = "${'" + Constants.JDBC_RESOURCE + "'}";
    public static final String CALLER_QUERY = "select password from EMPLOYEE where dpi_employee = ?"; //get pass by carnet
    public static final String GROUPS_QUERY = "select p.name_staff_position FROM STAFF_POSITION p,EMPLOYEE e where e.dpi_employee=?";
    public static final String PBKDF_ITERATIONS = "Pbkdf2PasswordHash.Iterations=3072";
    public static final String PBKDF_ALGORITHM = "Pbkdf2PasswordHash.Algorithm=PBKDF2WithHmacSHA256";
    public static final String PBKDF_SALT_SIZE = "Pbkdf2PasswordHash.SaltSizeBytes=64";
}
