package digger.model;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ColumnTest {

	@Test
	public void compareToTest() {
        Column columnA = new Column("COLUMN_A    ");
        Column columnAA = new Column("   COLUMN_A");

        assertThat(columnA.compareTo(columnAA)).isEqualTo(0);
        
        Column columnB = new Column(" COLUMN_B ");

        assertThat(columnA.compareTo(columnB)).isEqualTo(-1);
        assertThat(columnB.compareTo(columnA)).isEqualTo(1);

        Column column = new Column();

        assertThat(column.compareTo(columnA)).isEqualTo(-1);
    }
    
    @Test
    public void equalsTest() {
        Column columnA = new Column("COLUMN_A   ");
        Column columnAA = new Column("  COLUMN_A");

        assertThat(columnA.equals(columnAA)).isTrue();

        Column column1 = new Column(1l);
        Column column2 = new Column(2l);

        assertThat(column1.equals(column2)).isFalse();
        assertThat(column1.equals(column1)).isTrue();

        Column column = new Column();
        assertThat(column.equals(column)).isTrue();
    }
}