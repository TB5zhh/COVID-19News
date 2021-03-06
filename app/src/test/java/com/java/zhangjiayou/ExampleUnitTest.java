package com.java.zhangjiayou;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java.zhangjiayou.network.NoResponseError;
import com.java.zhangjiayou.network.PassagePortal;
import com.java.zhangjiayou.util.Passage;

import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws JsonProcessingException, NoResponseError {
        System.out.println("Hello!");

        List<Passage> list = new PassagePortal().getNewsFromType("news",4,40);
        for (Passage item :
                list) {
            System.out.println(item.getId());
        }

        assertEquals(4, 2 + 2);
    }

    @Test
    public void simple_test() {
        System.out.println(Long.parseLong("5eb4df22212e216209c3e37ce6bd5d0a", 16));

    }

    @Test
    public void more_test() throws NoResponseError {
        PassagePortal portal = new PassagePortal();
        List<Passage> news = portal.getNewsFromType("news", 1, 20);
        for (Passage i :
                news) {
            System.out.println(i.getTitle());
        }

    }

    @Test
    public void passage_test() {
        Passage passage = new PassagePortal().getNewsFromId("5f05f3f69fced0a24b2f84ee");
        System.out.println(passage.getTitle());
        assertEquals(passage == null, false);
    }


    @Test
    public void database_test() {
        Passage p = new Passage("123", "Hello!", "Not happy", new Date());
    }
}