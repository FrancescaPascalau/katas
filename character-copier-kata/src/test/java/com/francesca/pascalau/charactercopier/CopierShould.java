package com.francesca.pascalau.charactercopier;

import com.francesca.pascalau.kata.Copier;
import com.francesca.pascalau.kata.Destination;
import com.francesca.pascalau.kata.Source;
import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class CopierShould {

    public static final String NAME = "Francesca\n";

    private Source source = mock(Source.class);

    private Destination destination;

    @Test
    public void copy_the_characters_to_destination() {
        destination = mock(Destination.class);
        Copier copier = new Copier(source, destination);

        when(source.getChar())
                .thenReturn('F')
                .thenReturn('r')
                .thenReturn('a')
                .thenReturn('n')
                .thenReturn('c')
                .thenReturn('e')
                .thenReturn('s')
                .thenReturn('c')
                .thenReturn('a')
                .thenReturn('\n');

        copier.copy();

        InOrder inOrder = inOrder(destination);
        inOrder.verify(destination).setChar('F');
        inOrder.verify(destination).setChar('r');
        inOrder.verify(destination).setChar('a');
        inOrder.verify(destination).setChar('n');
        inOrder.verify(destination).setChar('c');
        inOrder.verify(destination).setChar('e');
        inOrder.verify(destination).setChar('s');
        inOrder.verify(destination).setChar('c');
        inOrder.verify(destination).setChar('a');
        inOrder.verify(destination).setChar('\n');
    }
}
