package com.generation.lojaDeGames.model;
import java.time.LocalDateTime;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.generation.blogpessoal.model.Tema;
import com.generation.blogpessoal.model.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "o atributo título é obrigatório")
	@Size(min=5, max = 100, message = "o atributo titulo deve conter no minimo 5 e no máximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "o atributo título é obrigatório")
	@Size(min=10, max = 1000, message = "o atributo titulo deve conter no minimo 10 e no máximo 1000 caracteres")
	private String texto;

	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne //colocar primeiro relacionamento
	@JsonIgnoreProperties("produto") //colocar depois para evitar recursividade 
	private Categoria categoria; //linkar a tabela e depois fazer getters and setters
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private Usuario usuario;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getTexto() {
		return texto;
	}


	public void setTexto(String texto) {
		this.texto = texto;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
