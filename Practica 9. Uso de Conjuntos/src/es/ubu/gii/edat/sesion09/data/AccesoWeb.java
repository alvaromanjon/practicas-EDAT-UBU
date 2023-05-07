package es.ubu.gii.edat.sesion09.data;

import java.time.LocalDateTime;

public class AccesoWeb implements Comparable<Object> {

	public enum SeccionWeb {
		Inicio, Servicios, Organizacion, Productos, Prensa, Blog, Contacto
	};

	private String IP;
	private LocalDateTime fechaYHora;
	private SeccionWeb destino;

	public AccesoWeb(SeccionWeb seccion, LocalDateTime time, String IP) {
		this.destino = seccion;
		this.fechaYHora = time;
		this.IP = IP;
	}

	public String getIP() {
		return IP;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public SeccionWeb getDestino() {
		return destino;
	}

	public void setProcedencia(SeccionWeb procedencia) {
		this.destino = procedencia;
	}

	@Override
	public String toString() {
		String s = "";
		s = s + destino.toString() + " - ";
		s = s + fechaYHora.toString() + " - ";
		s = s + IP.toString();
		return s;
	}

	//////////////

	@Override
	public boolean equals(Object o) {

		// TODO A completar por el estudiante
		// TODO To be completed by the students

	}

	@Override
	public int hashCode() {
		// TODO A completar por el estudiante
		// TODO To be completed by the students
	}

	@Override
	public int compareTo(Object o) {
		// TODO A completar por el estudiante
		// TODO To be completed by the students
	}
}
