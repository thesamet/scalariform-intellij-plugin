package com.thesamet.intellij;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;

/**
 * Created by gil308 on 12/10/2016.
 */
@State(name = "ScalariformSettings", storages = {@Storage("scalariform.xml")})
public class ScalariformState implements PersistentStateComponent<ScalariformState> {
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

    public boolean isAlignSingleLineCase() {
        return alignSingleLineCase;
    }

    public void setAlignSingleLineCase(boolean alignSingleLineCase) {
        this.alignSingleLineCase = alignSingleLineCase;
    }

    public boolean isCompactControlReadability() {
        return compactControlReadability;
    }

    public void setCompactControlReadability(boolean compactControlReadability) {
        this.compactControlReadability = compactControlReadability;
    }

    public boolean isCompactStringConcatenation() {
        return compactStringConcatenation;
    }

    public void setCompactStringConcatenation(boolean compactStringConcatenation) {
        this.compactStringConcatenation = compactStringConcatenation;
    }

    public boolean isDoubleIndentClassDeclaration() {
        return doubleIndentClassDeclaration;
    }

    public void setDoubleIndentClassDeclaration(boolean doubleIndentClassDeclaration) {
        this.doubleIndentClassDeclaration = doubleIndentClassDeclaration;
    }

    public boolean isFormatXML() {
        return formatXML;
    }

    public void setFormatXML(boolean formatXML) {
        this.formatXML = formatXML;
    }

    public boolean isIndentPackageBlocks() {
        return indentPackageBlocks;
    }

    public void setIndentPackageBlocks(boolean indentPackageBlocks) {
        this.indentPackageBlocks = indentPackageBlocks;
    }

    public boolean isIndentWithTabs() {
        return indentWithTabs;
    }

    public void setIndentWithTabs(boolean indentWithTabs) {
        this.indentWithTabs = indentWithTabs;
    }

    public boolean isMultilineScalaDocCommentsStartOnFirstLine() {
        return multilineScalaDocCommentsStartOnFirstLine;
    }

    public void setMultilineScalaDocCommentsStartOnFirstLine(boolean multilineScalaDocCommentsStartOnFirstLine) {
        this.multilineScalaDocCommentsStartOnFirstLine = multilineScalaDocCommentsStartOnFirstLine;
    }

    public boolean isPreserveDanglineCloseParenthesis() {
        return preserveDanglineCloseParenthesis;
    }

    public void setPreserveDanglineCloseParenthesis(boolean preserveDanglineCloseParenthesis) {
        this.preserveDanglineCloseParenthesis = preserveDanglineCloseParenthesis;
    }

    public boolean isPlaceScalaDocAsteriskBeneathSecondAsterisk() {
        return placeScalaDocAsteriskBeneathSecondAsterisk;
    }

    public void setPlaceScalaDocAsteriskBeneathSecondAsterisk(boolean placeScalaDocAsteriskBeneathSecondAsterisk) {
        this.placeScalaDocAsteriskBeneathSecondAsterisk = placeScalaDocAsteriskBeneathSecondAsterisk;
    }

    public boolean isPreserveSpaceBeforeArguments() {
        return preserveSpaceBeforeArguments;
    }

    public void setPreserveSpaceBeforeArguments(boolean preserveSpaceBeforeArguments) {
        this.preserveSpaceBeforeArguments = preserveSpaceBeforeArguments;
    }

    public boolean isRewriteArrowSymbols() {
        return rewriteArrowSymbols;
    }

    public void setRewriteArrowSymbols(boolean rewriteArrowSymbols) {
        this.rewriteArrowSymbols = rewriteArrowSymbols;
    }

    public boolean isSpaceBeforeColon() {
        return spaceBeforeColon;
    }

    public void setSpaceBeforeColon(boolean spaceBeforeColon) {
        this.spaceBeforeColon = spaceBeforeColon;
    }

    public boolean isSpaceInsideParenthesis() {
        return spaceInsideParenthesis;
    }

    public void setSpaceInsideParenthesis(boolean spaceInsideParenthesis) {
        this.spaceInsideParenthesis = spaceInsideParenthesis;
    }

    public boolean isSpacesWithinPatternBinders() {
        return spacesWithinPatternBinders;
    }

    public void setSpacesWithinPatternBinders(boolean spacesWithinPatternBinders) {
        this.spacesWithinPatternBinders = spacesWithinPatternBinders;
    }

    public Integer getAlignSingleLineCaseStatementsMaxArrowIndent() {
        return alignSingleLineCaseStatementsMaxArrowIndent;
    }

    public void setAlignSingleLineCaseStatementsMaxArrowIndent(Integer alignSingleLineCaseStatementsMaxArrowIndent) {
        this.alignSingleLineCaseStatementsMaxArrowIndent = alignSingleLineCaseStatementsMaxArrowIndent;
    }

    public Integer getIndentSpaces() {
        return indentSpaces;
    }

    public void setIndentSpaces(Integer indentSpaces) {
        this.indentSpaces = indentSpaces;
    }

    public boolean isIndentLocalDefs() {
        return indentLocalDefs;
    }

    public void setIndentLocalDefs(boolean indentLocalDefs) {
        this.indentLocalDefs = indentLocalDefs;
    }

    public boolean isSpaceInsideBrackets() {
        return spaceInsideBrackets;
    }

    public void setSpaceInsideBrackets(boolean spaceInsideBrackets) {
        this.spaceInsideBrackets = spaceInsideBrackets;
    }

    public boolean isAlignParameters() {

        return alignParameters;
    }

    public void setAlignParameters(boolean alignParameters) {
        this.alignParameters = alignParameters;
    }

    @Override
    public void loadState(ScalariformState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    @Override
    public ScalariformState getState() {
        return this;
    }
}
