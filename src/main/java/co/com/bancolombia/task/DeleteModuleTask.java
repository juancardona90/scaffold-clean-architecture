package co.com.bancolombia.task;

import co.com.bancolombia.factory.ModuleBuilder;
import co.com.bancolombia.utils.Utils;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.options.Option;
import org.gradle.api.tasks.options.OptionValues;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteModuleTask extends DefaultTask {
    private final ModuleBuilder builder = new ModuleBuilder(getProject());

    private String module;

    @Option(option = "module", description = "Set module name to delete")
    public void setModule(String module) {
        this.module = module;
    }

    @OptionValues("module")
    public List<String> getModules() {
        return new ArrayList<>(getProject().getChildProjects().keySet());
    }

    @TaskAction
    public void deleteModule() throws IOException {
        if (module == null || !getProject().getChildProjects().containsKey(module)) {
            throw new IllegalArgumentException("No valid module name is set, usage: gradle deleteModule --module "
                    + Utils.formatTaskOptions(getModules()));
        }
        builder.deleteModule(module);
        builder.removeFromSettings(module);
        builder.removeDependencyFromModule("app-service", "implementation project(':" + module + "')");
        builder.persist();
    }
}
