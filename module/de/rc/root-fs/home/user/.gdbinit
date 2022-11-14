set print pretty on
define phpbt
    set $ed=executor_globals.current_execute_data
    while $ed
        print {(char*)((zend_execute_data *)$ed)->func.common.scope.name.val, (char*)((zend_execute_data *)$ed)->func.common.function_name.val}
        set $ed = ((zend_execute_data *)$ed)->prev_execute_data
    end
end
