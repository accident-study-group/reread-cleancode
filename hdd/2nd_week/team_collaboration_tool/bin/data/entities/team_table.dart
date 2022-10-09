import 'package:drift/drift.dart';
import 'package:uuid/uuid.dart';

@DataClassName('TeamEntity')
class TeamTable extends Table {
  TeamTable();

  @override
  Set<Column> get primaryKey => {id};

  TextColumn get id =>
      text().nullable().clientDefault(() => Uuid().v4())();

  TextColumn get name => text().unique()();
}
