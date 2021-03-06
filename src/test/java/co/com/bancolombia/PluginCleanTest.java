/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package co.com.bancolombia;

import org.gradle.api.Task;
import org.gradle.testfixtures.ProjectBuilder;
import org.gradle.api.Project;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * A simple unit test for the 'co.com.bancolombia.greeting' plugin.
 */
public class PluginCleanTest {

    @Test
    public void pluginRegistersATask() {
        // Arrange
        String taskGroup = "Clean Architecture";
        String descriptionTask1 = "Scaffolding clean architecture project";
        String descriptionTask2 = "Generate model in domain layer";
        String descriptionTask3 = "Generate use case in domain layer";
        String descriptionTask4 = "Generate entry point in infrastructure layer";
        String descriptionTask5 = "Generate driven adapter in infrastructure layer";
        String descriptionTask6 = "Validate that project references are not violated";
        Project project = ProjectBuilder.builder().build();
        project.getPlugins().apply("co.com.bancolombia.cleanArchitecture");

        // Act
        Task task = project.getTasks().findByName("cleanArchitecture");
        Task task2 = project.getTasks().findByName("generateModel");
        Task task3 = project.getTasks().findByName("generateUseCase");
        Task task4 = project.getTasks().findByName("generateEntryPoint");
        Task task5 = project.getTasks().findByName("generateDrivenAdapter");
        Task task6 = project.getTasks().findByName("validateStructure");

        //Assert
        assertEquals(taskGroup, task.getGroup());
        assertEquals(descriptionTask1, task.getDescription());

        assertEquals(taskGroup, task2.getGroup());
        assertEquals(descriptionTask2, task2.getDescription());

        assertEquals(taskGroup, task3.getGroup());
        assertEquals(descriptionTask3, task3.getDescription());

        assertEquals(taskGroup, task4.getGroup());
        assertEquals(descriptionTask4, task4.getDescription());

        assertEquals(taskGroup, task5.getGroup());
        assertEquals(descriptionTask5, task5.getDescription());

        assertEquals(taskGroup, task6.getGroup());
        assertEquals(descriptionTask6, task6.getDescription());
    }

}
