package br.ufrpe.app.model.entity;

	public class Equipamento {
		private String descricao;
		private String codigo;
		private String tipo;
		
		public Equipamento() {

		}

		public Equipamento(String descricao, String codigo, String tipo, boolean composto) {
			super();
			this.descricao = descricao;
			this.codigo = codigo;
			this.tipo = tipo;
		
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Equipamento other = (Equipamento) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Equipamento [descricao=" + descricao + ", codigo=" + codigo + ", tipo=" + tipo + "]";
		}

	}
