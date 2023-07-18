package Selenium;

import java.util.function.Function;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

class WebDriverWaitWithMessage extends WebDriverWait {

    private String message;

    public WebDriverWaitWithMessage(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    public WebDriverWait failWith(String message) {
        if (message == null || message.length() == 0) {
            throw new IllegalArgumentException("Error message must not be null nor empty");
        }
        this.message = message;
        return this;
    }

    @Override
    public <V> V until(Function<? super WebDriver, V> isTrue) {
        if (message == null) {
            return super.until(isTrue);
        } else {
            try {
                return super.until(isTrue);
            } catch (TimeoutException e) {
                throw new TimeoutException(message, e);
            }
        }
    }
}
