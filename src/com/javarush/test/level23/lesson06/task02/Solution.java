package com.javarush.test.level23.lesson06.task02;

import static com.javarush.test.level23.lesson06.task02.Solution.Constants.*;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {

    public final static class Constants {
        public static final String SERVER_IS_NOT_ACCESSIBLE_FOR_NOW = "Server is not accessible for now.";
        public static final String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
        public static final String USER_IS_BANNED = "User is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }
    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(SERVER_IS_NOT_ACCESSIBLE_FOR_NOW);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(SERVER_IS_NOT_ACCESSIBLE_FOR_NOW, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(USER_IS_BANNED);
        }

        public BannedUserException(Throwable cause) {
            super(USER_IS_BANNED, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(ACCESS_IS_DENIED);
        }

        public RestrictionException(Throwable cause) {
            super(ACCESS_IS_DENIED, cause);
        }
    }
}
