package quiz;

import java.io.Serializable;
import lombok.Data;


@Data
public class UserDTO implements Serializable {

    private Integer id;
    private String pregunta;
    private String todasLasRespuestas;
    private String respuesta;
    private String respuestaLetras;
    
}
