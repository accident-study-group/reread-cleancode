import 'package:drift/drift.dart';
import 'package:uuid/uuid.dart';
import '../data/data_sources/team_dao.dart';
import '../data/entities/team_table.dart';
part 'database.g.dart';


@DriftDatabase(tables: [TeamTable], daos: [TeamDao])
class Database extends _$Database {
  Database(QueryExecutor e) : super(e);

  @override
  int get schemaVersion => 1;

  @override
  MigrationStrategy get migration {
    return MigrationStrategy(

    );
  }
}