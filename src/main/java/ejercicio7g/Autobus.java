/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio7g;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author jorge
 */
public class Autobus {
    
    // Atributos
    private String ruta;
    private String partida;
    private String destino;
    private List<LocalTime> horas;
    
    // constructores
    public Autobus() {
    }

    public Autobus(String ruta, String partida, String destino, List<LocalTime> horas) {
        this.ruta = ruta;
        this.partida = partida;
        this.destino = destino;
        this.horas = horas;
    }

    // Getters y setters
    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<LocalTime> getHoras() {
        return horas;
    }

    public void setHoras(List<LocalTime> horas) {
        this.horas = horas;
    }

    // Equals y hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.ruta);
        hash = 17 * hash + Objects.hashCode(this.partida);
        hash = 17 * hash + Objects.hashCode(this.destino);
        hash = 17 * hash + Objects.hashCode(this.horas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autobus other = (Autobus) obj;
        if (!Objects.equals(this.ruta, other.ruta)) {
            return false;
        }
        if (!Objects.equals(this.partida, other.partida)) {
            return false;
        }
        if (!Objects.equals(this.destino, other.destino)) {
            return false;
        }
        return Objects.equals(this.horas, other.horas);
    }

    // Método toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\"").append(ruta).append("\"");
        sb.append(" \"").append(partida).append(" - ");
        sb.append(destino).append("\" ");
        for(LocalTime h:horas){
            sb.append(h.format(DateTimeFormatter.ofPattern("HH:mm"))).append(" ");
        }
        return sb.toString();
    }
    
    
    
}
