// Compiled by ClojureScript 0.0-2156
goog.provide('cljs_gwt.core');
goog.require('cljs.core');
goog.require('cljs_gwt.css');
goog.require('cljs_gwt.css');
cljs.core.enable_console_print_BANG_.call(null);
cljs_gwt.core.new_button = (function new_button(name){var button = document.createElement("BUTTON");button.type = "button";
button.innerHTML = (function (){var or__3403__auto__ = name;if(cljs.core.truth_(or__3403__auto__))
{return or__3403__auto__;
} else
{return "";
}
})();
return button;
});
cljs_gwt.core.new_text_box = (function new_text_box(){var text_box = document.createElement("INPUT");text_box.type = "text";
text_box.className = "gwt-TextBox";
return text_box;
});
/**
* @param {...*} var_args
*/
cljs_gwt.core.new_label_base = (function() { 
var new_label_base__delegate = function (p__4747){var map__4749 = p__4747;var map__4749__$1 = ((cljs.core.seq_QMARK_.call(null,map__4749))?cljs.core.apply.call(null,cljs.core.hash_map,map__4749):map__4749);var inline_QMARK_ = cljs.core.get.call(null,map__4749__$1,new cljs.core.Keyword(null,"inline?","inline?",2964694072));if(cljs.core.truth_(inline_QMARK_))
{return document.createSpanElement();
} else
{return document.createDivElement();
}
};
var new_label_base = function (var_args){
var p__4747 = null;if (arguments.length > 0) {
  p__4747 = cljs.core.array_seq(Array.prototype.slice.call(arguments, 0),0);} 
return new_label_base__delegate.call(this,p__4747);};
new_label_base.cljs$lang$maxFixedArity = 0;
new_label_base.cljs$lang$applyTo = (function (arglist__4750){
var p__4747 = cljs.core.seq(arglist__4750);
return new_label_base__delegate(p__4747);
});
new_label_base.cljs$core$IFn$_invoke$arity$variadic = new_label_base__delegate;
return new_label_base;
})()
;
cljs_gwt.core.new_label = (function new_label(){var label = cljs_gwt.core.new_label_base.call(null,new cljs.core.Keyword(null,"inline?","inline?",2964694072),false);label.className = "gwt-Label";
return label;
});
var send_button_4751 = cljs_gwt.core.new_button.call(null,"Send");var name_field_4752 = cljs_gwt.core.new_text_box.call(null);var error_label_4753 = cljs_gwt.core.new_label.call(null);cljs_gwt.css.add_style_name.call(null,send_button_4751,"sendButton");
document.getElementById("nameFieldContainer").appendChild(name_field_4752);
document.getElementById("sendButtonContainer").appendChild(send_button_4751);
document.getElementById("errorLabelContainer").appendChild(error_label_4753);
cljs.core.println.call(null,"Hello world! 121");
