package org.example.controllers.dishes;

import org.example.services.dishes.AddDishesService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

class AddDishesControllerTest {

    private AddDishesService addDishesServiceMock;
    private AddDishesController addDishesController;

    @BeforeEach
    void setUp() {
        addDishesServiceMock = mock(AddDishesService.class);
        addDishesController = new AddDishesController(addDishesServiceMock);
    }

    @Test
    void execute_ShouldCallAddDishesService_WhenNoExceptionOccurs() {
        // Arrange
        doNothing().when(addDishesServiceMock).addDishesExecute();

        // Act
        addDishesController.execute();

        // Assert
        verify(addDishesServiceMock, times(1)).addDishesExecute();
    }

    @Test
    void execute_ShouldHandleException_WhenAddDishesServiceThrowsException() {
        // Arrange
        doThrow(new RuntimeException("Simulated exception")).when(addDishesServiceMock).addDishesExecute();

        // Act
        addDishesController.execute();

        // Assert
        verify(addDishesServiceMock, times(1)).addDishesExecute();
    }
}
