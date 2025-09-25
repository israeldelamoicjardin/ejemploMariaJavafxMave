module es.israeldelamo.demomariadb {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires org.checkerframework.checker.qual;
    requires org.slf4j;


    opens es.israeldelamo.demomariadb to javafx.fxml;
    exports es.israeldelamo.demomariadb;
    exports es.israeldelamo.demomariadb.dao;
    exports es.israeldelamo.demomariadb.modelos;
    exports es.israeldelamo.demomariadb.controladores;
    opens es.israeldelamo.demomariadb.controladores to javafx.fxml, javafx.base;
    opens es.israeldelamo.demomariadb.modelos to javafx.fxml, javafx.base;
}