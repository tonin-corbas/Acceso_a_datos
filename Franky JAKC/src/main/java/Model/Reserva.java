package Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Table(name = "reserva", indexes = {
        @Index(name = "id_hotel", columnList = "id_hotel"),
        @Index(name = "id_persona", columnList = "id_persona"),
        @Index(name = "id_tipo", columnList = "id_tipo")
})
public class Reserva {
    @Id
    @Column(name = "id_reserva", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "fecha_checkin", nullable = false)
    private LocalDate fechaCheckin;

    @NotNull
    @Column(name = "fecha_checkout", nullable = false)
    private LocalDate fechaCheckout;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_hotel")
    private Hotel idHotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_persona")
    private org.example.Persona idPersona;

    @NotNull
    @Column(name = "num_habitaciones", nullable = false)
    private Integer numHabitaciones;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_tipo")
    private Model.Tipohabitacion idTipo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaCheckin() {
        return fechaCheckin;
    }

    public void setFechaCheckin(LocalDate fechaCheckin) {
        this.fechaCheckin = fechaCheckin;
    }

    public LocalDate getFechaCheckout() {
        return fechaCheckout;
    }

    public void setFechaCheckout(LocalDate fechaCheckout) {
        this.fechaCheckout = fechaCheckout;
    }

    public Hotel getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(Hotel idHotel) {
        this.idHotel = idHotel;
    }

    public org.example.Persona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(org.example.Persona idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getNumHabitaciones() {
        return numHabitaciones;
    }

    public void setNumHabitaciones(Integer numHabitaciones) {
        this.numHabitaciones = numHabitaciones;
    }

    public Model.Tipohabitacion getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Model.Tipohabitacion idTipo) {
        this.idTipo = idTipo;
    }

}