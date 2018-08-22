package get_ready.data_structs.linked_lists;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ListUtilsTest {

    @Test
    public void ListUtilsSizeTest() {
        ListNode<Integer> a = new ListNode<Integer>(1);
        ListNode<Integer> b = new ListNode<Integer>(3);
        ListNode<Integer> c = new ListNode<Integer>(5);
        a.next = b;
        b.next = c;
        assertThat(ListUtils.size(a), is(3));
    }
}