package com.thesamet.intellij;

import com.intellij.openapi.components.*;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by nadavsr on 6/1/14.
 */
@State(name = "ScalariformSettings", storages = {@Storage(id = "other", file = StoragePathMacros.APP_CONFIG + "/other.xml"
)})
public class ScalariformApplicationComponent implements Configurable, ApplicationComponent, PersistentStateComponent<ScalariformApplicationComponent> {
    private boolean alignParameters = false;
    private boolean alignSingleLineCase = false;
    private boolean compactControlReadability = false;
    private boolean compactStringConcatenation = false;
    private boolean doubleIndentClassDeclaration = false;
    private boolean formatXML = false;
    private boolean indentPackageBlocks = true;
    private boolean indentWithTabs = false;
    private boolean multilineScalaDocCommentsStartOnFirstLine = false;
    private boolean preserveDanglineCloseParenthesis = false;
    private boolean placeScalaDocAsteriskBeneathSecondAsterisk = false;
    private boolean preserveSpaceBeforeArguments = false;
    private boolean rewriteArrowSymbols = false;
    private boolean spaceBeforeColon = false;
    private boolean spaceInsideParenthesis = false;
    private boolean spacesWithinPatternBinders = true;
    private Integer alignSingleLineCaseStatementsMaxArrowIndent = 40;
    private Integer indentSpaces = 2;
    private boolean indentLocalDefs;
    private boolean spaceInsideBrackets;

    public ScalariformApplicationComponent() {
    }

    public void initComponent() {
        // TODO: insert component initialization logic here
    }

    public void disposeComponent() {
        // TODO: insert component disposal logic here
    }

    @NotNull
    public String getComponentName() {
        return "com.thesamet.intellij.ScalariformApplicationComponent";
    }

    public boolean isAlignParameters() {
        return alignParameters;
    }

    public void setAlignParameters(final boolean alignParameters) {
        this.alignParameters = alignParameters;
    }

    public boolean isAlignSingleLineCase() {
        return alignSingleLineCase;
    }

    public void setAlignSingleLineCase(final boolean alignSingleLineCase) {
        this.alignSingleLineCase = alignSingleLineCase;
    }

    public boolean isCompactControlReadability() {
        return compactControlReadability;
    }

    public void setCompactControlReadability(final boolean compactControlReadability) {
        this.compactControlReadability = compactControlReadability;
    }

    public boolean isCompactStringConcatenation() {
        return compactStringConcatenation;
    }

    public void setCompactStringConcatenation(final boolean compactStringConcatenation) {
        this.compactStringConcatenation = compactStringConcatenation;
    }

    public boolean isDoubleIndentClassDeclaration() {
        return doubleIndentClassDeclaration;
    }

    public void setDoubleIndentClassDeclaration(final boolean doubleIndentClassDeclaration) {
        this.doubleIndentClassDeclaration = doubleIndentClassDeclaration;
    }

    public boolean isFormatXML() {
        return formatXML;
    }

    public void setFormatXML(final boolean formatXML) {
        this.formatXML = formatXML;
    }

    public boolean isIndentPackageBlocks() {
        return indentPackageBlocks;
    }

    public void setIndentPackageBlocks(final boolean indentPackageBlocks) {
        this.indentPackageBlocks = indentPackageBlocks;
    }

    public boolean isIndentWithTabs() {
        return indentWithTabs;
    }

    public void setIndentWithTabs(final boolean indentWithTabs) {
        this.indentWithTabs = indentWithTabs;
    }

    public boolean isMultilineScalaDocCommentsStartOnFirstLine() {
        return multilineScalaDocCommentsStartOnFirstLine;
    }

    public void setMultilineScalaDocCommentsStartOnFirstLine(final boolean multilineScalaDocCommentsStartOnFirstLine) {
        this.multilineScalaDocCommentsStartOnFirstLine = multilineScalaDocCommentsStartOnFirstLine;
    }

    public boolean isPreserveDanglineCloseParenthesis() {
        return preserveDanglineCloseParenthesis;
    }

    public void setPreserveDanglineCloseParenthesis(final boolean preserveDanglineCloseParenthesis) {
        this.preserveDanglineCloseParenthesis = preserveDanglineCloseParenthesis;
    }

    public boolean isPlaceScalaDocAsteriskBeneathSecondAsterisk() {
        return placeScalaDocAsteriskBeneathSecondAsterisk;
    }

    public void setPlaceScalaDocAsteriskBeneathSecondAsterisk(final boolean placeScalaDocAsteriskBeneathSecondAsterisk) {
        this.placeScalaDocAsteriskBeneathSecondAsterisk = placeScalaDocAsteriskBeneathSecondAsterisk;
    }

    public boolean isPreserveSpaceBeforeArguments() {
        return preserveSpaceBeforeArguments;
    }

    public void setPreserveSpaceBeforeArguments(final boolean preserveSpaceBeforeArguments) {
        this.preserveSpaceBeforeArguments = preserveSpaceBeforeArguments;
    }

    public boolean isRewriteArrowSymbols() {
        return rewriteArrowSymbols;
    }

    public void setRewriteArrowSymbols(final boolean rewriteArrowSymbols) {
        this.rewriteArrowSymbols = rewriteArrowSymbols;
    }

    public boolean isSpaceBeforeColon() {
        return spaceBeforeColon;
    }

    public void setSpaceBeforeColon(final boolean spaceBeforeColon) {
        this.spaceBeforeColon = spaceBeforeColon;
    }

    public boolean isSpaceInsideParenthesis() {
        return spaceInsideParenthesis;
    }

    public void setSpaceInsideParenthesis(final boolean spaceInsideParenthesis) {
        this.spaceInsideParenthesis = spaceInsideParenthesis;
    }

    public boolean isSpacesWithinPatternBinders() {
        return spacesWithinPatternBinders;
    }

    public void setSpacesWithinPatternBinders(final boolean spacesWithinPatternBinders) {
        this.spacesWithinPatternBinders = spacesWithinPatternBinders;
    }

    public Integer getAlignSingleLineCaseStatementsMaxArrowIndent() {
        return alignSingleLineCaseStatementsMaxArrowIndent;
    }

    public void setAlignSingleLineCaseStatementsMaxArrowIndent(final Integer alignSingleLineCaseStatementsMaxArrowIndent) {
        this.alignSingleLineCaseStatementsMaxArrowIndent = alignSingleLineCaseStatementsMaxArrowIndent;
    }

    public Integer getIndentSpaces() {
        return indentSpaces;
    }

    public void setIndentSpaces(final Integer indentSpaces) {
        this.indentSpaces = indentSpaces;
    }

    // Configurable
    ScalariformConfigurationForm form = null;

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
        return (form != null) && form.isModified(this);
    }

    @Override
    public void apply() throws ConfigurationException {
        if (form != null) {
            form.getData(this);
        }
    }

    @Override
    public void reset() {
        if (form != null) {
            form.setData(this);
        }
    }

    @Override
    public void disposeUIResources() {
        form = null;
    }

    public void loadState(ScalariformApplicationComponent state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public ScalariformApplicationComponent getState() {
        return this;
    }

    public boolean isIndentLocalDefs() {
        return indentLocalDefs;
    }

    public void setIndentLocalDefs(final boolean indentLocalDefs) {
        this.indentLocalDefs = indentLocalDefs;
    }

    public boolean isSpaceInsideBrackets() {
        return spaceInsideBrackets;
    }

    public void setSpaceInsideBrackets(final boolean spaceInsideBrackets) {
        this.spaceInsideBrackets = spaceInsideBrackets;
    }
}
