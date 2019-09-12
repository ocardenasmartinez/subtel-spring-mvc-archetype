package cl.subtel.utilities.entities;

public class IngresoOp {

	private Integer numeroIngreso;
	private String fechaIngreso;
	private String glosa;
	private String tipoPersona;
	private String rutSolicitante;
	private String remitente;
	private String nombreTazonSocial;
	private String representante;
	private String codigoTramite;
	private String codigoTipoDocumento;
	private String codigoMateria;

	public Integer getNumeroIngreso() {
		return numeroIngreso;
	}

	public void setNumeroIngreso(Integer numeroIngreso) {
		this.numeroIngreso = numeroIngreso;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}

	public String getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public String getRutSolicitante() {
		return rutSolicitante;
	}

	public void setRutSolicitante(String rutSolicitante) {
		this.rutSolicitante = rutSolicitante;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getNombreTazonSocial() {
		return nombreTazonSocial;
	}

	public void setNombreTazonSocial(String nombreTazonSocial) {
		this.nombreTazonSocial = nombreTazonSocial;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	public String getCodigoTramite() {
		return codigoTramite;
	}

	public void setCodigoTramite(String codigoTramite) {
		this.codigoTramite = codigoTramite;
	}

	public String getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}

	public void setCodigoTipoDocumento(String codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}

	public String getCodigoMateria() {
		return codigoMateria;
	}

	public void setCodigoMateria(String codigoMateria) {
		this.codigoMateria = codigoMateria;
	}

	@Override
	public String toString() {
		return "IngresoOp [numeroIngreso=" + numeroIngreso + ", fechaIngreso=" + fechaIngreso + ", glosa=" + glosa
				+ ", tipoPersona=" + tipoPersona + ", rutSolicitante=" + rutSolicitante + ", remitente=" + remitente
				+ ", nombreTazonSocial=" + nombreTazonSocial + ", representante=" + representante + ", codigoTramite="
				+ codigoTramite + ", codigoTipoDocumento=" + codigoTipoDocumento + ", codigoMateria=" + codigoMateria
				+ "]";
	}

}
