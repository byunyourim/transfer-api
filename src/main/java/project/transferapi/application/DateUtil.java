package project.transferapi.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.time.format.DateTimeFormatter.ofPattern;

public class DateUtil {
    public static final DateTimeFormatter DEFAULT_YEAR_MONTH_PATTERN = ofPattern( "yyyyMM" );
    public static final DateTimeFormatter SHORT_YEAR_MONTH_PATTERN1 = ofPattern( "yyyy-MM" );
    public static final DateTimeFormatter DEFAULT_DATE_PATTERN = ofPattern( "yyyyMMdd" );
    public static final DateTimeFormatter SHOR_DATE_PATTERN1 = ofPattern( "MM.dd" );
    public static final DateTimeFormatter SHOR_DATE_PATTERN2 = ofPattern( "MM월dd일" );
    public static final DateTimeFormatter SHOR_DATE_PATTERN3 = ofPattern( "yyMMdd" );
    public static final DateTimeFormatter DEFAULT_TIME_PATTERN = ofPattern( "HHmmss" );

    public static final DateTimeFormatter DEFAULT_DATETIME_PATTERN = ofPattern( "yyyyMMddHHmmss" );
    public static final DateTimeFormatter DEFAULT_NANO_DATETIME_PATTERN = ofPattern( "yyyyMMddHHmmssSSS" );
    public static final DateTimeFormatter SEQUENCE_DATETIME_PATTERN = ofPattern( "yyMMddHHmmss" );
    public static final DateTimeFormatter LONG_DATETIME_PATTERN = ofPattern( "yyyy-MM-dd HH:mm:ss" );

    public static LocalDateTime toDateTime( final String str ) {
        return convert( LocalDateTime::parse, str, DEFAULT_DATETIME_PATTERN );
    }

    public static String toDateTimeString( final LocalDateTime datetime, final DateTimeFormatter formatter ) {
        return datetime == null ? "" : convert( datetime:: format, formatter );
    }

    public static LocalDateTime nowDateTime() {
        return LocalDateTime.now();
    }

    public static String nowDateTimeString() {
        return dateTimeString( nowDateTime(), DEFAULT_DATETIME_PATTERN );
    }

    public static String nowSequenceDateTimeString() {
        return dateTimeString( nowDateTime(), SEQUENCE_DATETIME_PATTERN );
    }

    public static String dateTimeString( LocalDateTime dateTime, DateTimeFormatter formatter ) {
        return dateTime == null ? "" : dateTime.format( formatter );
    }

    private static < T, R > R convert( Function<T, R> func, T arg ) {
        try {
            return func.apply( arg );
        } catch ( Exception ex ) {
            return null;
        }
    }

    private static < T, U, R > R convert( BiFunction<T, U, R> func, T arg, U arg2 ) {
        try {
            return func.apply( arg, arg2 );
        } catch ( Exception ex ) {
            return null;
        }
    }
}
