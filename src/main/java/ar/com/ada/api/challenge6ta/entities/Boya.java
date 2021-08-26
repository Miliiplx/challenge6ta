package ar.com.ada.api.challenge6ta.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "boya")
public class Boya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boya_id")
    private Integer boyaId;

    @Column(name = "color_luz_id")
    private Integer colorLuz;

    @Column(name = "longitud_instalacion")
    private Double longitudInstalacion;

    @Column(name = "latitud_instalacion")
    private Double latitudInstalacion;

    @OneToMany(mappedBy = "boya", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Muestra> mustras = new ArrayList<>();

    public void generarMuestra(Muestra muestra) {
        this.mustras.add(muestra);
    }

    public Integer getBoyaId() {
        return boyaId;
    }

    public List<Muestra> getMustras() {
        return mustras;
    }

    public void setMustras(List<Muestra> mustras) {
        this.mustras = mustras;
    }

    public void setBoyaId(Integer boyaId) {
        this.boyaId = boyaId;
    }

    public ColorLuzEnum getColorLuz() {
        return ColorLuzEnum.parse(this.colorLuz);
    }

    public void setColorLuz(Integer colorLuz) {
        this.colorLuz = colorLuz;
    }

    public Double getLongitudInstalacion() {
        return longitudInstalacion;
    }

    public void setLongitudInstalacion(Double longitudInstalacion) {
        this.longitudInstalacion = longitudInstalacion;
    }

    public Double getLatitudInstalacion() {
        return latitudInstalacion;
    }

    public void setLatitudInstalacion(Double latitudInstalacion) {
        this.latitudInstalacion = latitudInstalacion;
    }

    public enum ColorLuzEnum {

        NULL(1), ROJO(2), AMARILLO(3), VERDE(4), AZUL(5);

        private final int value;

        private ColorLuzEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static ColorLuzEnum parse(int id) {
            ColorLuzEnum status = null; // Default
            for (ColorLuzEnum item : ColorLuzEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }
}
