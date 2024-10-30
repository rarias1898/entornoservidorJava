package Streams.Ej11;

public class Curso {
	private String nombre;
	private Double duracion;
	private int numeroVideos;
	private int numeroAlumnos;
	
	public Curso(String nombre, Double duracion, int numeroVideos, int numeroAlumnos) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.numeroVideos = numeroVideos;
		this.numeroAlumnos = numeroAlumnos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getDuracion() {
		return duracion;
	}

	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public int getNumeroVideos() {
		return numeroVideos;
	}

	public void setNumeroVideos(int numeroVideos) {
		this.numeroVideos = numeroVideos;
	}

	public int getNumeroAlumnos() {
		return numeroAlumnos;
	}

	public void setNumeroAlumnos(int numeroAlumnos) {
		this.numeroAlumnos = numeroAlumnos;
	}
	
	
}
