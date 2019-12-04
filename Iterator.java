package デザインパターン;

import java.awt.print.Book;
import java.util.ArrayList;

interface Iterator {
public void first(); // 取り出し位置を最初の要素へ変える
public void next(); // 取り出し位置を次の要素へ変える
public boolean isDone(); // 取り出し位置が最後を超えたか？
public Object getItem(); // 現在の取り出し位置から取り出す
}

class BookListIterator implements Iterator{
	private BookListAggregate aggregate;
	private int current;

	public BookListIterator(BookListAggregate aggregate) {
		this.aggregate = aggregate;
		}

	@Override
	public void first() {
	current = 0;
	}

	@Override
	public void next() {
		current += 1;
		}

	@Override
	public boolean isDone() {
	if (current >= aggregate.getNumberOfStock()) {
	return true;
	}
	else {
	return false;
	}
	}

	@Override
	public Object getItem() {
	return aggregate.getAt(current);
	}
}

interface Aggregate {
public Iterator createIterator();
}
