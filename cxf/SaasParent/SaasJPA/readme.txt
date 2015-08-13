1. Refactory JPA project
Create new package in src/main/java called com.e2.dao.jpa
Move BookShelfServiceDaoImpl to src/main/java/com.e2.dao.jpa package

Create new package in src/test/java called com.e2.dao.jpa
BookShelfServiceDaoTest to src/test/java/com.e2.dao.jpa package

In src/test/resource folder, create new folder called jpa
move app-test-context.xml and test-db-context.xml to jpa folder

Edit BookShelfServiceDaoImpl.java, change
    @ContextConfiguration(locations = { "classpath:/app-test-context.xml"})
to
    @ContextConfiguration(locations = { "classpath:/jpa/app-test-context.xml"})

Edit app-test-context.xml, change    
    <context:component-scan base-package="com.e2.dao" />
to
    <context:component-scan base-package="com.e2.dao.jpa" />    