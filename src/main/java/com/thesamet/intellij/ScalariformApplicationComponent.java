package com.thesamet.intellij;

import com.intellij.openapi.components.*;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by nadavsr on 6/1/14.
 */
public class ScalariformApplicationComponent implements Configurable, ApplicationComponent {
    private ScalariformConfigurationForm form = null;
    private ScalariformState state = ServiceManager.getService(ScalariformState.class);

    public ScalariformApplicationComponent() {
    }

    @Override
    public void initComponent() {
    }

    @Override
    public void disposeComponent() {
    }

    @NotNull
    public String getComponentName() {
        return "com.thesamet.intellij.ScalariformApplicationComponent";
    }

    @Nls
    @Override
    public String getDisplayName() {
        return "Scalariform";
    }

    @Nullable
    @Override
    public String getHelpTopic() {
        return null;
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        if (form == null) {
            form = new ScalariformConfigurationForm();
        }
        return form.getRootComponent();
    }

    @Override
    public boolean isModified() {
        return (form != null) && form.isModified(state);
    }

    @Override
    public void apply() throws ConfigurationException {
        if (form != null) {
            form.getData(state);
        }
    }

    @Override
    public void reset() {
        if (form != null) {
            form.setData(state);
        }
    }

    @Override
    public void disposeUIResources() {
        form = null;
    }
}
