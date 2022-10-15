import 'package:drift/drift.dart';
import 'package:drift/native.dart';
import 'package:riverpod/riverpod.dart';
import 'package:uuid/uuid.dart';
import '../data/data_sources/team_dao_impl.dart';
import '../data/entities/team_table.dart';

part 'database.g.dart';

final databaseProvider = Provider<Database>((ref) => Database(NativeDatabase.memory()));

@DriftDatabase(tables: [TeamTable], daos: [TeamDaoImpl])
class Database extends _$Database {
  Database(QueryExecutor e) : super(e);

  @override
  int get schemaVersion => 1;

  @override
  MigrationStrategy get migration {
    return MigrationStrategy();
  }
}
