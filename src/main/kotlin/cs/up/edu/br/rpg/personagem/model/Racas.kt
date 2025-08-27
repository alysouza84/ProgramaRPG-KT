package cs.up.edu.br.rpg.personagem.model

/**
 * Arquivo de implementações concretas das raças.
 * Cada raça herda da classe abstrata 'Raca' e implementa suas propriedades.
 */

/**
 * Usa-se os dois pontos ':' para indicar que a classe 'Anao' "herda" da classe 'Raca'.
 * Ao herdar de 'Raca', ela é obrigada a implementar todas as propriedades abstratas
 * usando a palavra-chave 'override'.
 *
 * procurar difrença entre 'abstract' e 'sealed'
 *
 * classe: Equipamento. Personagem - falta fazer essa parte
 *
 */

class Anao : Raca() {
    override val nome: String = "Anão"
    override val movimento: Int = 6 // Anões têm uma velocidade de movimento de 6 metros por turno.
    override val temInfravisao: Boolean = true // Anões podem ver no escuro; Sobre-escrevendo habilidade do pai
    override val alinhamentoComum: String = "Ordem" // Anoes tendem a ser de alinhamento "Ordem".
    override val habilidadesRaciais: List<String> = listOf(
        "Minerador", "Vigoroso", "Armas Grandes", "Inimigos"
    )
}

class Humano : Raca(){
    override val nome: String = "Humano"
    override val movimento: Int = 9 // Humanos têm uma velocidade de movimento de 9 metros por turno.
    // Humanos não têm infravisão;
    override val alinhamentoComum: String = "Qualquer um"
    override val habilidadesRaciais: List<String> = listOf(
        "Aprendizado", "Adaptabilidade"
    )
}

class Elfo : Raca(){
    override val nome: String = "Elfo"
    override val movimento: Int = 9 // Elfos têm uma velocidade de movimento de 9 metros por turno.
    override val temInfravisao: Boolean = true // Elfos podem ver no escuro; Sobre-escrevendo habilidade do pai
    override val alinhamentoComum: String = "Neutro" // Elfos tendem a ser de alinhamento "Neutro".
    override val habilidadesRaciais: List<String> = listOf(
        "Visão na Penumbra", "Imunidade a Sono", "Transe", "Armas Élficas"
    )
}