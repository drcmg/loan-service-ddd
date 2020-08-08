package com.asc.loanservice.infrastructure.constant;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import static com.asc.loanservice.infrastructure.constant.ValidationOrder.*;


@GroupSequence({
        Default.class,
        Order2.class,
        Order3.class,
        Order4.class,
        Order5.class,
        Order6.class,
        Order7.class,
        Order8.class,
        Order9.class,
        Order10.class,
        Order11.class,
        Order12.class,
        Order13.class,
        Order14.class,
        Order15.class,
})
public interface ValidationOrder {

    interface Order2 { }
    interface Order3 { }
    interface Order4 { }
    interface Order5 { }
    interface Order6 { }
    interface Order7 { }
    interface Order8 { }
    interface Order9 { }
    interface Order10 { }
    interface Order11 { }
    interface Order12 { }
    interface Order13 { }
    interface Order14 { }
    interface Order15 { }
}