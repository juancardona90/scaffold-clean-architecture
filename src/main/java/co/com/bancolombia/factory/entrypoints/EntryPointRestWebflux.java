package co.com.bancolombia.factory.entrypoints;

import co.com.bancolombia.utils.FileUtils;
import co.com.bancolombia.exceptions.CleanException;
import co.com.bancolombia.factory.ModuleBuilder;
import co.com.bancolombia.factory.ModuleFactory;

import java.io.IOException;

public class EntryPointRestWebflux implements ModuleFactory {
    @Override
    public void buildModule(ModuleBuilder builder) throws IOException, CleanException {
        builder.addParamPackage(FileUtils.readProperties("package"));
        builder.setupFromTemplate("entry-point/rest-webflux");
        builder.appendToSettings("reactive-web", "infrastructure/entry-points");
        builder.appendDependencyToModule("app-service", "implementation project(':reactive-web')");
    }
}
