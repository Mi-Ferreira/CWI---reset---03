package br.com.cwi.reset.micheleferreira;

import java.time.LocalDate;

public class Ator {

   private Integer id=0;
   private String nome;
   private LocalDate dataNascimento;
   private StatusCarreira statusCarreira;
   private Integer anoInicioAtividade;

   public Ator(Integer id, String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
      this.id = id;
      this.nome = nome;
      this.dataNascimento = dataNascimento;
      this.statusCarreira = statusCarreira;
      this.anoInicioAtividade = anoInicioAtividade;
   }

   public static Integer getId() {
      return id++;
   }
}
