package com.lxx.kotlin1.rxbus


import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

object RxBus {


    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
     */
    var bus: Subject<Any> = PublishSubject.create<Any>().toSerialized()


    /**
     * 发送一个新的事件，所有订阅此事件的订阅者都会收到
     */
    fun post(action: Any) {
        bus.onNext(action)
    }

    /**
     *  用 code 指定订阅此事件的对应 code 的订阅者
     */
    fun postWithCode(code: Int, action: Any) {
        bus.onNext(Action(code, action))
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    fun <T> toObservable(eventType: Class<T>): Observable<T> {
        return bus.ofType(eventType)
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者,
     */
    fun <T> toObservableWithCode(code: Int, eventType: Class<T>): Observable<T> {
        return bus.ofType(Action::class.java)
                .filter { (code1) -> code1 == code }
                .map { (_, data) -> data }
                .cast(eventType)
    }

}
