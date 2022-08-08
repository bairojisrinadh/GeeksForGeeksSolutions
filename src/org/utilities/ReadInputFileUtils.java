package org.utilities;

import org.constants.InputType;
import org.domain.objects.GFGInputTemplate;
import org.domain.objects.GFGIntArrayInputTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.stream.Stream;

public final class ReadInputFileUtils {
    private static final String DEFAULT_FILE_EXTN = ".txt";
    private static final String WHITE_SPACE = " ";

    public static GFGInputTemplate readFile(String fileName, InputType inputType) {
        if (fileName == null || fileName.isBlank() || fileName.isEmpty()) {
            throw new IllegalArgumentException("Input file name should not be null or empty!");
        }

        if (inputType == null) {
            throw new IllegalArgumentException("Input file type should not be null. pick any one from this list: " + Arrays.toString(InputType.values()));
        }

        Path inputFileAbsolutePath = ReadInputFileUtils.getInputFileAbsolutePath(fileName);

        return switch (inputType) {
            case INT -> processIntFeedFileToGFGInputTemplate(inputFileAbsolutePath);
            default -> throw new IllegalArgumentException("Trying to access invalid input type, please re-check!");
        };
    }

    private static GFGInputTemplate processIntFeedFileToGFGInputTemplate(Path inputFileAbsolutePath) {
        GFGIntArrayInputTemplate inputObj = new GFGIntArrayInputTemplate();

        try (BufferedReader br = Files.newBufferedReader(inputFileAbsolutePath)) {
            String inputArgs = br.readLine();
            String[] args = inputArgs.split(WHITE_SPACE);

            if (args != null) {
                inputObj.setInputLength(Integer.valueOf(args[0]));
                if (args.length == 2) {
                    inputObj.setRequiredOutputIfAny(Integer.valueOf(args[1]));
                }
            }

            String inputValues = br.readLine();
            String[] values = inputValues.split(WHITE_SPACE);
            int[] toIntArray = Stream.of(values).mapToInt(Integer::parseInt).toArray();

            if (inputObj.getInputLength() != toIntArray.length) {
                throw new InputMismatchException(String.format("Processing Error: Unable to match given input length: %s with " +
                        "total no. of processed input values: %s", inputObj.getInputLength(), toIntArray.length));
            }
            inputObj.setArr(toIntArray);

        } catch (IOException e) {
            throw new RuntimeException("Unable to read input file, Reason: " + e);
        }
        return inputObj;
    }

    private static Path getInputFileAbsolutePath(String fileName) {
        final String envRootDir = System.getProperty("user.dir");
        Path projectRootDir = Paths.get(".").normalize().toAbsolutePath();

        if (!projectRootDir.startsWith(envRootDir)) {
            throw new RuntimeException("Project Root dir not found in user directory.");
        }

        if (fileName.indexOf('.') == -1) {
            fileName += DEFAULT_FILE_EXTN;
        }
        return Paths.get(projectRootDir.toString(), "resources", "inputFiles", fileName);
    }
}
