package com.thesamet.intellij

import com.intellij.openapi.actionSystem.{ AnAction, AnActionEvent, CommonDataKeys }
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.ServiceManager
import com.intellij.openapi.fileEditor.{ FileDocumentManager, FileEditorManager }

import scalariform.formatter.preferences._
import scalariform.formatter.preferences.AlignSingleLineCaseStatements.MaxArrowIndent
import scalariform.formatter.ScalaFormatter
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.editor.Document

case class FileDocument(file: VirtualFile, document: Document) {
  def isScala: Boolean = file.getFileType.getName == "Scala"
}

class ScalariformFormatAction extends AnAction {
  override def update(event: AnActionEvent): Unit = {
    event.getPresentation.setEnabled(getCurrentFileDocument(event).exists(_.isScala))
  }

  override def actionPerformed(event: AnActionEvent) {
    lazy val pref = formattingPreferences
    getCurrentFileDocument(event)
      .filter(_.isScala)
      .foreach {
        fileDoc =>
          val source = fileDoc.document.getText()
          val formatted = ScalaFormatter.format(source, formattingPreferences = pref)
          if (source != formatted) {
            ApplicationManager.getApplication.runWriteAction(new Runnable {
              override def run(): Unit = {
                fileDoc.document.setText(formatted)
              }
            })
          }
      }
  }

  private def getCurrentFileDocument(event: AnActionEvent): Option[FileDocument] = for {
    project <- Option(event.getData(CommonDataKeys.PROJECT))
    editor <- Option(FileEditorManager.getInstance(project).getSelectedTextEditor)
    document <- Option(editor.getDocument)
    vfile <- Option(FileDocumentManager.getInstance().getFile(document))
  } yield FileDocument(vfile, document)

  private def formattingPreferences: FormattingPreferences = {
    val component: ScalariformState = ServiceManager.getService(classOf[ScalariformState])

    FormattingPreferences.setPreference(RewriteArrowSymbols, component.isRewriteArrowSymbols)
      .setPreference(IndentSpaces, component.getIndentSpaces.toInt)
      .setPreference(SpaceBeforeColon, component.isSpaceBeforeColon)
      .setPreference(CompactStringConcatenation, component.isCompactStringConcatenation)
      .setPreference(PreserveSpaceBeforeArguments, component.isPreserveSpaceBeforeArguments)
      .setPreference(AlignParameters, component.isAlignParameters)
      .setPreference(DoubleIndentClassDeclaration, component.isDoubleIndentClassDeclaration)
      .setPreference(FormatXml, component.isFormatXML)
      .setPreference(IndentPackageBlocks, component.isIndentPackageBlocks)
      .setPreference(AlignSingleLineCaseStatements, component.isAlignSingleLineCase)
      .setPreference(MaxArrowIndent, component.getAlignSingleLineCaseStatementsMaxArrowIndent.toInt)
      .setPreference(IndentLocalDefs, component.isIndentLocalDefs)
      .setPreference(PreserveDanglingCloseParenthesis, component.isPreserveDanglineCloseParenthesis)
      .setPreference(SpaceInsideParentheses, component.isSpaceInsideParenthesis)
      .setPreference(SpaceInsideBrackets, component.isSpaceInsideBrackets)
      .setPreference(SpacesWithinPatternBinders, component.isSpacesWithinPatternBinders)
      .setPreference(MultilineScaladocCommentsStartOnFirstLine, component.isMultilineScalaDocCommentsStartOnFirstLine)
      .setPreference(IndentWithTabs, component.isIndentWithTabs)
      .setPreference(CompactControlReadability, component.isCompactControlReadability)
      .setPreference(PlaceScaladocAsterisksBeneathSecondAsterisk, component.isPlaceScalaDocAsteriskBeneathSecondAsterisk)
  }

}
