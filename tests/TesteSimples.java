import org.junit.Assert;
import org.junit.Test;

public class TesteSimples {

    @Test
    public void verificaNomeTest() {
        String nome = "Matheus";
        Assert.assertEquals("Matheus", nome);
    }

    @Test
    public void verificaNomeDiferenteTest() {
        String nome = "Katriel";
        Assert.assertNotEquals("João", nome);
    }
}
