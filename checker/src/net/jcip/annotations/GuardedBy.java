package net.jcip.annotations;

import java.lang.annotation.*;

import org.checkerframework.checker.lock.qual.GuardedByInaccessible;
import org.checkerframework.checker.lock.qual.LockHeld;
import org.checkerframework.framework.qual.PostconditionAnnotation;
import org.checkerframework.framework.qual.PreconditionAnnotation;
import org.checkerframework.framework.qual.SubtypeOf;
import org.checkerframework.framework.qual.TypeQualifier;

// The JCIP annotation can be used on a field (in which case it corresponds
// to the Lock Checker's @GuardedBy annotation) or on a method (in which case
// it is a declaration annotation corresponding to the Lock Checker's @Holding
// annotation).
// It is preferred to use these Checker Framework annotations instead:
//  org.checkerframework.checker.lock.qual.GuardedBy
//  org.checkerframework.checker.lock.qual.Holding

@TypeQualifier
@SubtypeOf(GuardedByInaccessible.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE })
@PreconditionAnnotation(qualifier = LockHeld.class)
public @interface GuardedBy {
    /**
     * The Java value expressions that need to be held.
     *
     * @see <a
     *      href="http://types.cs.washington.edu/checker-framework/current/checkers-manual.html#java-expressions-as-arguments">Syntax
     *      of Java expressions</a>
     */
    String[] value() default {};
}
