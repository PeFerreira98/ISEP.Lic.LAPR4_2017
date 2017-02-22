/*
 * This code is based on Jason Dunkelberger (a.k.a dirkraft) as stated below
*/
 
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Jason Dunkelberger (a.k.a dirkraft)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

// For plantuml support
import net.sourceforge.plantuml.FileFormat
import net.sourceforge.plantuml.FileFormatOption
import net.sourceforge.plantuml.SourceStringReader
import org.apache.commons.io.FilenameUtils
// For gradle
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Delete
import org.gradle.api.tasks.TaskAction
// For File
import java.nio.file.Files
import java.nio.file.Path
import groovy.io.FileType

/**
 *
 */
class RenderPlantUmlTask extends DefaultTask {

    def Path assetsPathInput = project.projectDir.toPath().resolve('src/main/java/')
    //def Path assetsPathOutput = project.projectDir.toPath().resolve('assets/')
    def Path assetsPathOutput = project.projectDir.toPath().resolve('build/docs/javadoc/')
   
    RenderPlantUmlTask() {
        new File('./src/main/java/').eachFileRecurse( FileType.DIRECTORIES, 
            { file ->
                file.eachFileMatch(~/.*.puml/) 
                { pumlFile -> 
                    inputs.file pumlFile
                    outputs.file getDestination(pumlFile, '.png').toFile()
                }
            }
        )
    }
    
    Path getDestination(File puml, String extension) {
        String baseName = FilenameUtils.getBaseName(puml.name)
        String destName = "${baseName}"
        String basePath = FilenameUtils.getFullPath(puml.path)
        def Path newPath = project.projectDir.toPath().resolve(basePath + destName + extension)
        Path relPath = assetsPathInput.relativize(newPath)
        assetsPathOutput.resolve(relPath)
    }

    String getDirectory(File file) {
        FilenameUtils.getFullPath(file.path)
    }
    
    @TaskAction
    def render() {

        Path projectPath = project.projectDir.toPath()
        for (File puml : inputs.files) {
            String relPumlPath = projectPath.relativize(puml.toPath()).toString()
            String pumlContent = new String(Files.readAllBytes(puml.toPath()), 'UTF-8')
           
            // IMPORTANT:
            // It is necessary to create the directory if it does not existe yet!
            
            // Now, generate the file
            SourceStringReader reader = new SourceStringReader(pumlContent)
            Path destPathPng = getDestination(puml, '.png')

            if (!destPathPng.toFile().exists())
            {
                def dir=getDirectory(destPathPng.toFile())
                // println "Directory=${dir}"
                def subdir = new File(dir)
                subdir.mkdirs()
            }
            
            println "Rendering ${relPumlPath} to ${projectPath.relativize(destPathPng)}"
            reader.generateImage(new FileOutputStream(destPathPng.toFile()), new FileFormatOption(FileFormat.PNG))
        }
    }
}

/*
class CleanPlantUmlTask extends Delete {

    def Path assetsPath = project.projectDir.toPath().resolve('assets/')

    CleanPlantUmlTask() {
        for (Path puml : Files.newDirectoryStream(assetsPath, '*.puml')) {
            //delete getDestination(puml.toFile(), '.svg').toFile()
            delete getDestination(puml.toFile(), '.png').toFile()
        }
    }

    Path getDestination(File puml, String extension) {
        String baseName = FilenameUtils.getBaseName(puml.name)
        String destName = "${baseName}"
        assetsPath.resolve(destName + extension)
    }
}
*/
