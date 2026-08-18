module com.example.aula2exercicio2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.aula2exercicio2 to javafx.fxml;
    exports com.example.aula2exercicio2;
}