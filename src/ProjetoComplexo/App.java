package ProjetoComplexo;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Heroi taffeson = new Heroi("Taffesson", 60, 2);
        Monstro diabreteInfenal = new Monstro("Diabrete Infernal", 50);

        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (diabreteInfenal.getVida() > 0) {
            System.out.println("######################################################################################");
            System.out.println("❤️ Vida de Taffeson: " + taffeson.getVida() + " PV | 🐉 Vida do "+ diabreteInfenal.getNome() +": " + diabreteInfenal.getVida() + " PV");
            System.out.println("🎒 Poções restantes: " + taffeson.getPocoes());
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> {
                    int novaVidaDoMonstro = taffeson.atacar(random, diabreteInfenal.getVida());
                    diabreteInfenal.setVida(novaVidaDoMonstro);
                }
                case 2 -> {
                    taffeson.usarPocao();
                }
                case 3 -> {
                    taffeson.defender();
                }
                case 4 -> {
                    int novaVidaDoMonstro = taffeson.ataqueEspecial(diabreteInfenal.getVida());
                    diabreteInfenal.setVida(novaVidaDoMonstro);
                }
                case 5 -> {
                    taffeson.fugir();
                    return;
                }
                default -> {
                    System.out.println("Opção inválida!");
                    continue;
                }
            }

            // ATAQUE DO MONSTRO
            diabreteInfenal.atacar(random, taffeson);

            // PARADA DE 3 SEGUNDOS PARA O USUÁRIO CONSEGUIR LER
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (diabreteInfenal.getVida() <= 0) {
            // Definindo Xp do Monstro
            diabreteInfenal.setXp(random.nextInt(20) + 10);
            // Adicionando Xp do Monstro ao Xp do Herói
            taffeson.setXp(taffeson.getXp() + diabreteInfenal.getXp());

            // Mensagens finais
            System.out.println("🎉 " + taffeson.getNome() + " derrotou o monstro e ganhou " + taffeson.getXp() + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de" + taffeson.getNome() + "!");
        } else {
            System.out.println("💀 " + taffeson.getNome() + " foi derrotado... o vilarejo está em perigo!");
        }
    }
}
