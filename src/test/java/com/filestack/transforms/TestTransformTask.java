package com.filestack.transforms;

import static org.junit.Assert.assertTrue;

import com.filestack.errors.InvalidArgumentException;
import com.filestack.errors.InvalidParameterException;
import com.filestack.errors.ValidationException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestTransformTask {
  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private static final TransformTask TASK = new TransformTask("task");

  static {
    TASK.addOption("option1", 1);
    TASK.addOption("option2", 1.0);
    TASK.addOption("option3", "value");
    TASK.addOption("option4", new Integer[] {1, 1, 1, 1});
  }

  private static final String TASK_STRING =
      "task=option1:1,option2:1.0,option3:value,option4:[1,1,1,1]";

  @Test
  public void testTaskToString() {
    String output = TASK.toString();

    String message = String.format("Task string malformed\nCorrect: %s\nOutput: %s",
        TASK_STRING, output);
    assertTrue(message, output.equals(TASK_STRING));
  }

  @Test
  public void testOptionNullKey() throws ValidationException {
    TransformTask transformTask = new TransformTask("test");

    thrown.expect(InvalidArgumentException.class);
    thrown.expectMessage("Task option key cannot be empty");
    transformTask.addOption(null, "");
  }

  @Test
  public void testOptionNullValue() {
    TransformTask transformTask = new TransformTask("test");
    Assert.assertEquals(0, transformTask.options.size());
    transformTask.addOption("key", null);
    Assert.assertEquals(0, transformTask.options.size());
  }
}
