import java.util.Random;
import java.util.Scanner;

public class JogoFuncoesComplexo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int vidaHeroi = 60;
        int vidaMonstro = 50;
        int pocao = 2;
        int xp = 0;
        boolean especialDisponivel = true;
        boolean defendeu = false;

        // História inicial
        System.out.println("Era uma vez em um reino distante...");
        System.out.println("Um jovem herói chamado Taffeson foi escolhido para enfrentar um terrível monstro.");
        System.out.println("O destino do vilarejo depende de sua coragem e de suas escolhas!");
        System.out.println("Prepare-se para a batalha! \n");

        System.out.println("Bem-vindo ao RPG das Funções!");
        System.out.println("Ajude Taffeson a derrotar o monstro para salvar o vilarejo.\n");

        while (vidaMonstro > 0) {
            System.out.println("\n❤️ Vida de Taffeson: " + vidaHeroi + " PV | 🐉 Vida do Monstro: " + vidaMonstro);
            System.out.println("🎒 Poções restantes: " + pocao);
            System.out.println("Escolha sua ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Usar Poção");
            System.out.println("3 - Defender");
            System.out.println("4 - Poder Especial");
            System.out.println("5 - Fugir");
            int escolha = sc.nextInt();

            if (escolha == 1) {
                // TODO: chamar a função atacar()
                vidaMonstro = atacar(vidaMonstro, rand);

                // ######################################################################################
                // Essa função deve:
                // 1. Gerar um número aleatório entre 8 e 12 para o dano.
                // 2. Ter 20% de chance de ataque crítico (dano dobrado).
                // 3. Mostrar mensagens no console ("Taffeson atacou...", "Crítico!" etc).
                // 4. Retornar a nova vida do monstro após o ataque.
                // vidaMonstro = atacar(vidaMonstro, rand);
                // ######################################################################################
            } else if (escolha == 2) {
                // TODO: chamar a função usarPocao()
                if(pocao > 0) {
                    pocao--;
                    vidaHeroi = usarPocao(vidaHeroi);
                } else {
                    System.out.println("Não há poções restantes! 🎒");
                }

                // ######################################################################################
                // Essa função deve:
                // 1. Verificar se Taffeson ainda tem poções.
                // 2. Se tiver, recuperar 15 de vida.
                // 3. Mostrar mensagens ("Você usou uma poção", "Não há poções restantes").
                // 4. Retornar a nova vida de Taffeson.
                // vidaHeroi = usarPocao(vidaHeroi, pocao);
                // if (pocao > 0) pocao--; // só gasta se tinha
                // ######################################################################################
            } else if (escolha == 3) {
                // TODO: chamar a função defender()
                defendeu = defender();


                // ######################################################################################
                // Essa função deve:
                // 1. Apenas imprimir uma mensagem avisando que Taffeson está defendendo.
                // 2. Reduzir dano em 50%.
                // defender();
                // ######################################################################################
            } else if (escolha == 4) {
                // TODO: chamar a função poderEspecial()
                if (especialDisponivel) {
                    vidaMonstro = poderEspecial(vidaMonstro);
                    especialDisponivel = false;
                } else {
                    System.out.println("❌ O poder especial já foi usado!");
                }

                // ######################################################################################
                // Essa função deve:
                // 1. Só poder ser usada UMA vez no jogo.
                // 2. Causar 25 de dano fixo no monstro.
                // 3. Mostrar mensagens ("Taffeson usou o poder especial!").
                // if (especialDisponivel) {
                //     vidaMonstro = poderEspecial(vidaMonstro);
                //     especialDisponivel = false;
                // } else {
                //     System.out.println("❌ O poder especial já foi usado!");
                // }
                // ######################################################################################
            } else if (escolha == 5) {
                // TODO: chamar a função fugir()
                fugir();
                return;

                // ######################################################################################
                // Essa função deve:
                // 1. Mostrar mensagem de que Taffeson fugiu da batalha.
                // 2. Encerrar o jogo imediatamente.
                // fugir();
                // ######################################################################################
            } else {
                System.out.println("Opção inválida!");
                continue;
            }

            //TODO leve essa logica para uma função chamada Ataque de Mostro()
            vidaHeroi = ataqueDoMonstro(vidaHeroi, rand, defendeu);
            defendeu = false;

            // Pede para Thread parar de executar por 3 segundos
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        if (vidaMonstro <= 0) {
            // TODO: chamar a função ganharXP()
            // Essa função deve:
            // 1. Gerar um número aleatório entre 10 e 30.
            // 2. Retornar esse valor como experiência (XP).
            // 3. Mostrar mensagem de vitória com o XP ganho.
             xp = ganharXP(rand);
            System.out.println("🎉 Taffeson derrotou o monstro e ganhou " + xp + " XP!");
            System.out.println("🏆 O vilarejo foi salvo graças à bravura de Taffeson!");
        } else {
            System.out.println("💀 Taffeson foi derrotado... o vilarejo está em perigo!");
        }
    }

    private static int ganharXP(Random rand) {
        return rand.nextInt(20) + 10;
    }

    private static void fugir() {
        System.out.println("TAFFESON FUGIU PARA AS MONTANHAS COM SUA BANDEIRA LARANJA!");
    }

    private static int poderEspecial(int vidaMonstro) {
        vidaMonstro -= 25;
        System.out.println("️Taffeson usou o poder especial! 🪬");
        return vidaMonstro;
    }

    private static boolean defender() {
        System.out.println("Taffeson se defendeu e consegiu -50% de dano! 🛡️");
        return true;
    }

    private static int usarPocao(int vidaHeroi) {
        System.out.println("Taffeson usou uma poção 🎒");
        vidaHeroi += 15;
        return vidaHeroi;

    }

    private static int ataqueDoMonstro(int vidaHeroi, Random rand, boolean defendeu) {
        int ataqueMonstro = rand.nextInt(10) + 5; // dano entre 5 e 15
        boolean critico = rand.nextInt(100) < 15; // 15% de chance crítico
        if (critico) {
            ataqueMonstro *= 2;
            System.out.println("O monstro acertou um CRÍTICO! 💥");
        }
        if(defendeu) {
            ataqueMonstro = ataqueMonstro / 2;
        }
        vidaHeroi -= ataqueMonstro;
        System.out.println("🐉 O monstro atacou e causou " + ataqueMonstro + " de dano!");
        return vidaHeroi;
    }

    private static int atacar(int vidaMonstro, Random rand) {
        int danoAleatorio = rand.nextInt(4) + 8;
        boolean critico = rand.nextDouble(100) < 20;

        if(critico) {
            danoAleatorio *= 2;
            System.out.println("Taffeson fez um ataque crítico que causou " +  danoAleatorio + " PV ❤️");
        } else {
            System.out.println("Taffeson fez um ataque que causou " +  danoAleatorio + " PV ❤️");
        }
        vidaMonstro -= danoAleatorio;
        System.out.println("🐉 Vida atual do Monstro: " + vidaMonstro);
        return vidaMonstro;
    }

}
